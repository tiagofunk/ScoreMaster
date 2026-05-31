
document.querySelector("form").addEventListener("submit", async function(event) {
    event.preventDefault();

    const clubData = {
        name: document.getElementById("name").value,
        city: document.getElementById("city").value,
        country: document.getElementById("country").value,
        foundation: document.getElementById("foundation").value
    };

    console.log(clubData);

    try {
        const response = await fetch("/clubs/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(clubData)
        });

        if (response.ok) {
            alert("Clube salvo com sucesso!");
            this.reset(); // limpa o formulário
        } else {
            alert("Erro ao salvar clube!");
            console.log(response.status);
        }

    } catch (error) {
        console.error("Erro:", error);
        alert("Falha na comunicação com o servidor");
    }
});
