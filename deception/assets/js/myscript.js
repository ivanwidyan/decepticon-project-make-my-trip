var myJson;
var table;

function LoadJSON() {
    myJson = (function () {
        var json = null;
        $.ajax({
            'async': false,
            'global': false,
            'url': "desktop.json",
            'dataType': "json",
            'success': function (data) {
                json = data;
            }
        });
        return json;
    })();
}

function CreateScenario() {
    LoadJSON();
    var tr;
    for (var x = 0; x < myJson.length; x++) {
        for (var key in myJson[x]) {
            if (key === "driver") {
                var h3 = document.createElement("h3");
                h3.innerHTML = "Test Type : " + myJson[x][key];
                document.body.appendChild(h3);
            }
        }
        for (var key in myJson[x]) {
            if (key === "nama") {
                var h2 = document.createElement("h2");
                h2.innerHTML = myJson[x][key];
                document.body.appendChild(h2);
                var p = document.createElement("p");
                p.setAttribute("id", "showData" + [x]);
                p.innerHTML = "";
                document.body.appendChild(p);
                table = document.createElement("table");

                CreateHeader()
            }
        }
        for (var key in myJson[x]) {
            if (key === "pokemonimage" || key === "screenshot") {
                var data = myJson[x][key];
                tr = table.insertRow(-1);
                var tabcel = tr.insertCell(0);
                tabcel.innerHTML = key;
                for (var string in data) {
                    var tabcel1 = tr.insertCell(-1)
                    if (data[string] === "-") {
                        tabcel1.innerHTML = data[string];
                    } else {
                        var img = document.createElement("img")
                        img.setAttribute("src", data[string])
                        img.setAttribute("width", "30")
                        img.setAttribute("length", "30")
                        tabcel1.appendChild(img);
                    }
                }
            } else if (key === "driver") {
            } else if (key === "nama") {
            } else {
                var data = myJson[x][key];
                tr = table.insertRow(-1);
                var tabcel = tr.insertCell(0);
                tabcel.innerHTML = key;
                for (var string in data) {
                    var tabcel1 = tr.insertCell(-1)
                    if (data[string] === "-") {
                        tabcel1.innerHTML = data[string];
                    } else {
                        if (string === "wikivsdb") {
                            var img = document.createElement("img")
                            img.setAttribute("src", data[string])
                            img.setAttribute("width", "30")
                            img.setAttribute("length", "30")
                            tabcel1.appendChild(img);
                        } else if (string === "dbvsapi") {
                            var img = document.createElement("img")
                            img.setAttribute("src", data[string])
                            img.setAttribute("width", "30")
                            img.setAttribute("length", "30")
                            // tabcel1.innerHTML = data[string];
                            tabcel1.appendChild(img);
                        } else {
                            tabcel1.innerHTML = data[string];
                        }
                    }
                }
                var divContainer = document.getElementById("showData" + [x]);
                divContainer.innerHTML = "";
                divContainer.appendChild(table);
            }
        }
    }
}

function CreateHeader() {
    tr = table.insertRow(-1);
    for (var j = 0; j <= 5; j++) {
        var th = document.createElement("th");
        if (j === 0) {
            th.innerHTML = "";
            tr.appendChild(th);
        }
        if (j === 1) {
            th.innerHTML = "Wikipedia";
            tr.appendChild(th);
        }
        if (j === 2) {
            th.innerHTML = "PokemonDB";
            tr.appendChild(th);
        }
        if (j === 3) {
            th.innerHTML = "PokeAPI";
            tr.appendChild(th);
        }
        if (j === 4) {
            th.innerHTML = "Wiki VS PokemonDB";
            tr.appendChild(th);
        }
        if (j === 5) {
            th.innerHTML = "PokemonDB VS PokemonAPI";
            tr.appendChild(th);
        }
    }

    function test1() {
        var app = angular.module('myApp', []);
        app.controller('myController',
            function ($scope, $http) {
                $scope.arrBirds = new Array;
                $http({
                    method: 'GET',
                    url: 'desktop.json',
                    dataType: 'json',
                    contentType: "application/json"
                }).then(function (response) {
                    $scope.arrBirds = response;
                    $scope.list = $scope.arrBirds.data;
                    console.log($scope.list);
                }, function (error) {

                });
            });
    }
}