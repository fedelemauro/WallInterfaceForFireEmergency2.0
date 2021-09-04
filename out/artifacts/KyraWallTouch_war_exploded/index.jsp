<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link rel="stylesheet" href="CSS/indexCSS.css" />

    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
  </head>
  <body>

   <form action="NuovaSegnalazione" method="post">
   <input id="nuovaSegnalazione" type="submit" value="Nuova Segnalazione">
   </form>
   <br>
   <form action="StoricoSegnalazioni" method="post">
       <input id="storicoSegnalazione" type="submit" value="Storico Segnalazioni">
   </form>









  <div class="container"></div>

  <div id="mapid"></div>
  <script>
    var mymap = L.map('mapid' , {zoomControl:false}).setView([40.73653493614584 , 14.704420068743447], 10);
    L.tileLayer('https://api.maptiler.com/maps/hybrid/{z}/{x}/{y}.jpg?key=HaNbmnUf9grWV9eOteOZ', {
      attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',

    }).addTo(mymap);
  </script>
  </body>
</html>
