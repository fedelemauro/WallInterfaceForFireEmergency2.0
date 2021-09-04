<%@ page import="KyraWallTouch.model.Agente" %>
<%@ page import="java.util.List" %>
<%@ page import="KyraWallTouch.model.AgenteDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link rel="stylesheet" href="CSS/segnalazioneCSS.css" />
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
</head>
<body>
<%
    AgenteDAO agenteDAO = new AgenteDAO();
    List<Agente> agenti= agenteDAO.doRetrieveAll();
%>
<div class="weather">
    <iframe id="meteo1"width="385" height="122" scrolling="no" frameborder="no" noresize="noresize" src="https://www.ilmeteo.it/box/previsioni.php?citta=${segnalazione.codiceMeteo}&type=real1&width=385&ico=2&lang=ita&days=6&font=Arial&fontsize=12&bg=FFFFFF&fg=000000&bgtitle=B3B3B3&fgtitle=000000&bgtab=F0F0F0&fglink=000000"></iframe>
    <br>
    <div class="weather2">
        <iframe id="meteo2" width="480" height="205" scrolling="no" frameborder="no" noresize="noresize" src="https://www.ilmeteo.it/box/previsioni.php?citta=${segnalazione.codiceMeteo}&type=day1&width=480&ico=2&lang=ita&days=6&font=Arial&fontsize=12&bg=FFFFFF&fg=000000&bgtitle=B3B3B3&fgtitle=000000&bgtab=F0F0F0&fglink=000000"></iframe>
    </div>
</div>
<button id="richiestaAgente"onClick="aiutoAgente()">Agente richiede aiuto</button>


<button id="agenteButton" onClick="agenteFunction()" style="border: 0; background: transparent"><img src="img/firefighterB.png" width="64" height="64" /></button>
<button id="veicoloButton"onClick="veicoloFunction()" style="border: 0; background: transparent"><img src="img/veicolo.png" width="82" height="41" /></button>


<select name="Lista Agenti" id="listaagenti">
    <% for (Agente s : agenti)
    {%>
    <option value=<%=s.getNome()%>><%=s.getNome()%>-<%=s.getEta()%>-<%=s.getSalute()%></option>
    <%}%>
</select>
<button id="agenteSelezionato" onClick="agenteSelezionato()">OK</button>

<script>
    function myFunction() {
        document.getElementById("meteo1").src = "https://www.ilmeteo.it/box/previsioni.php?citta=${segnalazione.codiceMeteo}&type=real1&width=385&ico=2&lang=ita&days=6&font=Arial&fontsize=12&bg=FFFFFF&fg=000000&bgtitle=B3B3B3&fgtitle=000000&bgtab=F0F0F0&fglink=000000";
        document.getElementById("meteo2").src = "https://www.ilmeteo.it/box/previsioni.php?citta=${segnalazione.codiceMeteo}&type=day1&width=480&ico=2&lang=ita&days=6&font=Arial&fontsize=12&bg=FFFFFF&fg=000000&bgtitle=B3B3B3&fgtitle=000000&bgtab=F0F0F0&fglink=000000";
    }
</script>

<div class="panel"></div>


<div id="mapid"></div>
<script>
    var mymap = L.map('mapid' , {zoomControl:false}).setView([${segnalazione.latitudine},${segnalazione.longitudine}], 15);
    L.tileLayer('https://api.maptiler.com/maps/hybrid/{z}/{x}/{y}.jpg?key=HaNbmnUf9grWV9eOteOZ', {
        attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',
    }).addTo(mymap);
</script>


<script>    //Script area in rosso con coordinate
var circle = L.circle([${segnalazione.latitudine},${segnalazione.longitudine}], {
    color: 'red',
    fillColor: '#f03',
    fillOpacity: 0.5,
    radius: 250
}).addTo(mymap);


/*
function onMapClick(e) {
    circle.bindPopup("Area Segnalazione:"+ e.latlng.toString());
}
*/
mymap.on('click', onMapClick);
</script>

<script> //cliccando sulla mappa ottengo coordinate + setto marker
var popup = L.popup();
var agente = false;
var veicolo = false;
var nome ="";

var aiuto = false;

function aiutoAgente(){
    aiuto=true;
}

function agenteFunction() {
    agente = true;
    veicolo=false;
}

function veicoloFunction() {
    veicolo = true;
    agente=false;
}

function agenteSelezionato(){
     nome = document.getElementById("listaagenti").value;
}

function onMapClick(e) {
        if (veicolo) {
            var myIcon = L.icon({
                iconUrl: 'img/veicolo.png',
                iconSize: [70, 30],
                iconAnchor: [22, 30],
                popupAnchor: [-3, -76],
            })

            veicolo = false;

            var marker = L.marker(e.latlng, {icon: myIcon}).on('click', onClick).addTo(mymap);
            popup
                .setLatLng(e.latlng)
                .setContent("<strong>Veicolo posizionato</strong>"+'<br />'+"Coordinate: "+e.latlng.toString().substring(6))
                .openOn(mymap);
        }

        if (agente)
        {
            var myIcon = L.icon({
                iconUrl: 'img/firefighterB.png',
                iconSize: [32, 32],
                iconAnchor: [10, 30],
                popupAnchor: [-3, -76],
            })

            agente=false;
            var marker = L.marker(e.latlng, {icon: myIcon}).on('click', onClick).addTo(mymap);
            popup
                .setLatLng(e.latlng)
                .setContent("<strong>Agente posizionato</strong>"+'<br />'+ "Coordinate: "+e.latlng.toString().substring(6))
                .openOn(mymap);

        }


}
mymap.on('click', onMapClick);


function onClick(e) {
    var link = '"aiutoAgente()"';
    if (aiuto)
    {
        var ax= '"warning"';
        var img = '"img/warning.jpg" width=90%' ;
        var linkE =  'onclick="emergency()"';

        var myIcon = L.icon({
            iconUrl: 'img/firefighterC.png',
            iconSize: [32, 32],
            iconAnchor: [10, 30],
            popupAnchor: [-3, -76],
        })
        e.target.setIcon(myIcon);

        var amb = L.icon({
            iconUrl: 'img/ambulance.png',
            iconSize: [70, 70],
            iconAnchor: [22, 30],
            popupAnchor: [-3, -76],
        })

        var marker = L.marker(e.latlng, {icon: amb}).addTo(mymap);

        popup.setLatLng(e.latlng).setContent("<strong id="+ax+">MESSAGGIO DI ATTENZIONE</strong><br><img src="+img+"><br><strong>Coordinate: </strong>"+e.latlng.toString().substring(6)+"<br /><strong>Nome:"+nome+"</strong><br /><strong>Età:${agente.eta} </strong><br /><strong>Team: </strong><br /><strong id="+ax+">Stato Salute: IN PERICOLO</strong><br /><button "+linkE+">INVIA SOCCORSI</button>").openOn(mymap);
        aiuto = false;

        alert("Agente ferito\n"+"Causa: Frattura\n"+"Coordinate: "+e.latlng);

    }
    else
    popup.setLatLng(e.latlng).setContent("<strong>Coordinate: </strong>"+e.latlng.toString().substring(6)+"<br /><strong>Nome:"+nome+"</strong><br /><strong>Età:${agente.eta} </strong><br /><strong>Team: </strong><br /><strong>Stato Salute:${agente.salute} </strong>").openOn(mymap);
}

function emergency(){
    alert("SOCCORSI INVIATI SULLA POSIZIONE DELL' OPERATORE");

   /* var amb = L.icon({
        iconUrl: 'img/ambulance.png',
        iconSize: [70, 30],
        iconAnchor: [22, 30],
        popupAnchor: [-3, -76],
    })

    var marker = L.marker(e.latlng, {icon: amb}).addTo(mymap);*/
}
</script>




</body>
</html>
