
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link rel="stylesheet" href="CSS/segnalazioneFormCSS.css" />
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
</head>
<body>
<div id="form">
<form action="CreaSegnalazione" method="post">
    <input type="text" id="segnalazione" name="Segnalazione" placeholder="Segnalazione">
    <div id="latlng">
        <input type="text" id="latitudine" style= "width:49%" name="Latitudine" placeholder="Latitudine">
        <input type="text" id="longitudine" style= "width:49%" name="Longitudine" placeholder="Longitutdine">
    </div>
    <input type="text" id="city" name="Citta" placeholder="Città">
    <input type="text" id="provincia" name="Provincia" placeholder="Provincia">
    <input type="text" id="via" name="Via" placeholder="Via">
    <input type="text" id="civico" name="Civico" placeholder="N.Civico">
    <input type="text" id="cap" name="Cap" placeholder="CAP">
    <input type="date" id="data" name="Data">
    <input type="submit" value="Crea Segnalazione" >
</form>
</div>

<div id="mapid"></div>
<script>
    var random = Math.random(37,45);
    var mymap = L.map('mapid' , {zoomControl:false}).setView([40.73653493614584 , 14.704420068743447], 10);
    L.tileLayer('https://api.maptiler.com/maps/hybrid/{z}/{x}/{y}.jpg?key=HaNbmnUf9grWV9eOteOZ', {
        attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',

    }).addTo(mymap);
</script>
</body>
</html>