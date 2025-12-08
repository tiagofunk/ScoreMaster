const searchInput = document.getElementById("stadiumSearch");
const stadiumIdInput = document.getElementById("stadium");
const suggestionList = document.getElementById("stadiumSuggestions");
const stadiumBox = document.getElementById("stadiumBox")
let timeout;

searchInput.addEventListener("input", function () {
    const query = searchInput.value.trim();
    stadiumIdInput.value = ""; // limpar id se alterar texto

    if (timeout) clearTimeout(timeout);
    
    if (query.length < 2) {
        suggestionList.style.display = "none";
        return;
    }

    timeout = setTimeout(async () => {
        const response = await fetch(`/stadiums/search?name=${encodeURIComponent(query)}`);

        if (!response.ok) return;
        const stadiums = await response.json();

        suggestionList.innerHTML = "";
        if (stadiums.length > 0) {
            stadiums.forEach(s => {
                const li = document.createElement("li");
                console.log(s)
                li.textContent = s.name + " - " + s.city + " - " + s.country;
                li.addEventListener("click", () => {
                    searchInput.value = s.name;
                    stadiumIdInput.value = s.id; 
                    suggestionList.style.display = "none";
                    stadiumBox.querySelector("h3").textContent=s.name;
                    stadiumBox.querySelector("p").textContent=s.city + " - " + s.country;
                    stadiumBox.style.display = "block";
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
