
document.querySelector("form").addEventListener("submit", async function(event) {
    event.preventDefault();

    alert("Teste")

    const playerData = {
        name: document.getElementById("name").value,
        birthday: document.getElementById("birthday").value,
        height: parseInt(document.getElementById("height").value),
        weight: parseFloat(document.getElementById("weight").value),
        country: document.getElementById("country").value,
        rightHanded: document.getElementById("destro").checked // true = destro, false = canhoto
    };

    console.log(playerData);

    try {
        const response = await fetch("/players/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(playerData)
        });

        if (response.ok) {
            alert("Jogador salvo com sucesso!");
            this.reset(); // limpa o formulário
        } else {
            alert("Erro ao salvar jogador!");
            console.log(response.status);
        }

    } catch (error) {
        console.error("Erro:", error);
        alert("Falha na comunicação com o servidor");
    }
});
