
document.querySelector("form").addEventListener("submit", async function(event) {
    event.preventDefault();

    const stadiumData = {
        name: document.getElementById("name").value,
        city: document.getElementById("city").value,
        country: document.getElementById("country").value,
        foundation: document.getElementById("foundation").value,
        capacity: parseInt( document.getElementById("capacity").value )
    };

    console.log(stadiumData);

    try {
        const response = await fetch("/stadiums/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(stadiumData)
        });

        if (response.ok) {
            alert("Estádio salvo com sucesso!");
            this.reset(); // limpa o formulário
        } else {
            alert("Erro ao salvar estádio!");
            console.log(response.status);
        }

    } catch (error) {
        console.error("Erro:", error);
        alert("Falha na comunicação com o servidor");
    }
});
