import { useState } from 'react';

const LocationBox = ({ info, showBox, setShowBox}) => {

    // const [show, setShow] = useState(true);

    if(showBox){
        return (
            <div className="location-info">
                <h2>Event Location Info</h2>
                <ul>
        <li>ID: <strong>{ info.id }</strong></li>
        <li>TITLE: <strong>{ info.title }</strong></li>
        <li>CATEGORIES: <strong>{ info.categories }</strong></li>
        <li>DATE: <strong>{ info.geometries }</strong></li>
                </ul>
        <button onClick={() => setShowBox(false)}>
            CLOSE THIS FUCK
        </button>
            </div>
        
        
        )

    } else {
        return (
            <></>
        )
    }
    
}

export default LocationBox