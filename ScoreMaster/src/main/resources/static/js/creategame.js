let timeout;

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
        const stadiums = await response.json();

        suggestionList.innerHTML = "";
        if (stadiums.length > 0) {
            stadiums.forEach(s => {
                const li = document.createElement("li");
                li.textContent = s.name + " - " + s.city + " - " + s.country;
                li.addEventListener("click", () => {
                    searchInput.value = s.name;
                    hiddenInput.value = s.id; 
                    suggestionList.style.display = "none";
                    resultBox.querySelector("h3").textContent=s.name;
                    resultBox.querySelector("p").textContent=s.city + " - " + s.country;
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
