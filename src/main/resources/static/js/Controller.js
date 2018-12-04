var Controller = (function () {

    function answer (number){
        document.getElementById("ans").innerHTML = number.value;
    }

    function loadDataFahrenheit(callback) {
        axios.get("/convertion/fahrenheit/"+document.getElementById("number").value)
            .then(function (response) {
                callback(response.data);
            }).catch(function (error) {
            console.log(error);
            alert("Error happened");
        });
    }

    function loadDataCelsius(callback) {
        axios.get("/convertion/celsius/"+document.getElementById("number").value)
            .then(function (response) {
                callback(response.data);
            }).catch(function (error) {
            console.log(error);
            alert("Error happened");
        });
    }

    function ToCelsius() {
        loadDataCelsius(answer);
    }

    function ToFahrenheit() {
        loadDataFahrenheit(answer);
    }

    return {
        ToCelsius: ToCelsius,
        ToFahrenheit: ToFahrenheit
    };
})();