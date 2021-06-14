mapboxgl.accessToken = 'pk.eyJ1Ijoic3VkaGFyc2Fuc3JpbmkiLCJhIjoiY2tveHg1MXBkMGs5cTJvbXBqbmg0a2xjbyJ9.0PnLX-EC5xaT-Dh4DaVTmQ';

navigator.geolocation.getCurrentPosition(successLocation, errorLocation, {enableHighAccuracy: true})

function successLocation(position){

    setupMap([position.coords.longitude, position.coords.latitude])

}

function errorLocation(){

}

function setupMap(center){
    const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11',
        center: center,
        zoom: 15

        });
    
        const nav = new mapboxgl.NavigationControl();
        map.addControl(nav);

        var directions = new MapboxDirections({
            accessToken: mapboxgl.accessToken
          });
          
          map.addControl(directions, 'top-left');

    



}
