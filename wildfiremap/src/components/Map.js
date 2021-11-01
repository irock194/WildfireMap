import { useState } from 'react'
import GoogleMapReact from 'google-map-react'
import LocationMarker from './FireMarker'
import LocationBox from './LocationBox'
import VolcanoMarker from './VolcanoMarker'
import StormMarker from './StormMarker'
import IceMarker from './IceMarker'

// define constants
const NATURAL_EVENT_WILDFIRE = 8;
const NATURAL_EVENT_VOLCANO = 12;
const NATURAL_EVENT_STORM = 10;
const NATURAL_EVENT_ICE = 15;

const Map = ({ eventData, center, zoom }) => {
    const [locationInfo, setLocationInfo] = useState(null)

    // useState hook to show locationBox or not
    const [ showBox, setShowBox] = useState(true);

    const markers = eventData.map((ev, index) => {
        if(ev.categories[0].id === NATURAL_EVENT_WILDFIRE) {
            return <LocationMarker key={index} lat={ev.geometries[0].coordinates[1]} lng={ev.geometries[0].coordinates[0]} onClick={() => setLocationInfo({ id: ev.id, title: ev.title, categories: ev.categories[0].title, geometries: ev.geometries[0].date})} />
        }

        if(ev.categories[0].id === NATURAL_EVENT_VOLCANO ) {
            return <VolcanoMarker key={index} lat={ev.geometries[0].coordinates[1]} lng={ev.geometries[0].coordinates[0]} onClick={() => setLocationInfo({ id: ev.id, title: ev.title, categories: ev.categories[0].title, geometries: ev.geometries[0].date})} />
        }

        if(ev.categories[0].id === NATURAL_EVENT_STORM ) {
            return <StormMarker key={index} lat={ev.geometries[0].coordinates[1]} lng={ev.geometries[0].coordinates[0]} onClick={() => setLocationInfo({ id: ev.id, title: ev.title, categories: ev.categories[0].title, geometries: ev.geometries[0].date})} />
        }

        if(ev.categories[0].id === NATURAL_EVENT_ICE ) {
            return <IceMarker key={index} lat={ev.geometries[0].coordinates[1]} lng={ev.geometries[0].coordinates[0]} onClick={() => setLocationInfo({ id: ev.id, title: ev.title, categories: ev.categories[0].title, geometries: ev.geometries[0].date})} />
        }

        return null
    })

    return (
        <div className="map">
            <GoogleMapReact
                bootstrapURLKeys={{ key: '' }}
                defaultCenter={ center }
                defaultZoom={ zoom }
            >
                {markers}
            </GoogleMapReact>
                {locationInfo && <LocationBox info={locationInfo} showBox={showBox} setShowBox={setShowBox}/>}
        </div>
    )
}

Map.defaultProps = {
    center: {
        lat: 42.3265,
        lng: -122.8756
    },
    zoom: 6
}

export default Map