let timeout;

function createSuggestionEvent(
    searchInput, hiddenInput, suggestionList, resultBox, url
){
    searchInput.addEventListener("input", function () {
    const query = searchInput.value.trim();
    hiddenInput.value = ""; // limpar id se alterar texto

    if (timeout) clearTimeout(timeout);
    
    if (query.length < 2) {
        suggestionList.style.display = "none";
        return;
    }

    timeout = setTimeout(async () => {
        const response = await fetch(`${url}${encodeURIComponent(query)}`);

        if (!response.ok) return;
        const data = await response.json();

        suggestionList.innerHTML = "";
        if (data.length > 0) {
            data.forEach(s => {
                const li = document.createElement("li");
                li.textContent = [s.name, s.city, s.country].filter(Boolean).join(" - ");
                li.addEventListener("click", () => {
                    searchInput.value = s.name;
                    hiddenInput.value = s.id; 
                    suggestionList.style.display = "none";
                    resultBox.querySelector("h3").textContent=s.name;
                    resultBox.querySelector("p").textContent=[s.city, s.country].filter(Boolean).join(" - ");
                    resultBox.style.display = "block";
                });
                suggestionList.appendChild(li);
            });
            suggestionList.style.display = "block";
        } else {
            suggestionList.style.display = "none";
        }
    }, 300); // debounce
});

    // fechar lista ao clicar fora
    document.addEventListener("click", (e) => {
        if (!e.target.closest("#stadiumSearch")) {
            suggestionList.style.display = "none";
        }
    });
}

document.addEventListener("DOMContentLoaded", () => {
    const fieldsArea = document.getElementById("fieldsArea")
    loadDateField(fieldsArea)
    loadHourField(fieldsArea)
    loadStadiumField(fieldsArea)
    loadCapacityField(fieldsArea)
    loadHomeClubField(fieldsArea)
    loadAwayClubField(fieldsArea)
    loadPlayerField(fieldsArea)

    createSuggestionEvent(
        document.getElementById("stadiumSearch"),
        document.getElementById("stadiumHiddenInput"),
        document.getElementById("stadiumSuggestions"),
        document.getElementById("stadiumBox"),
        "/stadiums/search?name="
    );

    createSuggestionEvent(
        document.getElementById("homeClubSearch"),
        document.getElementById("homeClubHiddenInput"),
        document.getElementById("homeClubeSuggestions"),
        document.getElementById("homeClubeBox"),
        "/clubs/search?name="
    );

    createSuggestionEvent(
        document.getElementById("awayClubSearch"),
        document.getElementById("awayClubHiddenInput"),
        document.getElementById("awayClubeSuggestions"),
        document.getElementById("awayClubeBox"),
        "/clubs/search?name="
    );

    createSuggestionEvent(
        document.getElementById("playerSearch"),
        document.getElementById("playerHiddenInput"),
        document.getElementById("playerSuggestions"),
        document.getElementById("playerBox"),
        "/players/search?name="
    );

});

function loadDateField(fields) {
    fields.innerHTML += 
        `<div>
            <label for="date">Data</label>
            <input type="date" id="date" name="date" required>
        </div>`
}

function loadHourField(fields) {
    fields.innerHTML += 
        `<div>
            <label for="hour">Hora</label>
            <input type="time" id="hour" name="hour" required>
        </div>`
}

function loadStadiumField(fields) {
    fields.innerHTML += 
        `<div class="autocomplete-container">
            <label for="stadium">Estádio</label>
            <input type="text" id="stadiumSearch" autocomplete="off" placeholder="Digite o nome do estádio" required>
            <input type="hidden" id="stadiumHiddenInput" name="stadiumId">
            <ul id="stadiumSuggestions" class="autocomplete-list"></ul>
            <div id="stadiumBox" class="resultBox">
                <h3>Nome</h3>
                <p>Cidade - País</p>
            </div>
        </div>`
}

function loadCapacityField(fields) {
    fields.innerHTML += 
        `<div>
            <label for="capacity">Capacidade (opcional)</label>
            <input type="number" id="capacity" name="capacity" min="0" placeholder="50000">
        </div>`
}

function loadHomeClubField(fields) {
    fields.innerHTML += 
        `<div class="autocomplete-container">
            <label for="homeClub">Clube Mandante</label>
            <input type="text" id="homeClubSearch" autocomplete="off" placeholder="Digite o nome do clube" required>
            <input type="hidden" id="homeClubHiddenInput" name="homeClub">
            <ul id="homeClubeSuggestions" class="autocomplete-list"></ul>
            <div id="homeClubeBox" class="resultBox">
                <h3>Nome</h3>
                <p>Cidade - País</p>
            </div>
        </div>`
}

function loadAwayClubField(fields) {
    fields.innerHTML += 
        `<div class="autocomplete-container">
            <label for="awayClub">Clube Visitante</label>
            <input type="text" id="awayClubSearch" autocomplete="off" placeholder="Digite o nome do clube" required>
            <input type="hidden" id="awayClubHiddenInput" name="awayClub">
            <ul id="awayClubeSuggestions" class="autocomplete-list"></ul>
            <div id="awayClubeBox" class="resultBox">
                <h3>Nome</h3>
                <p>Cidade - País</p>
            </div>
        </div>`
}

function loadPlayerField(fields) {
    fields.innerHTML += 
        `<div class="autocomplete-container">
            <label for="player">Gol do jogador</label>
            <input type="text" id="playerSearch" autocomplete="off" placeholder="Digite o nome do jogador" required>
            <input type="hidden" id="playerHiddenInput" name="player">
            <ul id="playerSuggestions" class="autocomplete-list"></ul>
            <div id="playerBox" class="resultBox">
                <h3>Nome</h3>
                <p>País</p>
            </div>
        </div>`
}