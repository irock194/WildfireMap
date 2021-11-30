import React, { useState, useEffect } from 'react'
import Map from './components/Map'
import Loader from './components/Loader'
import Header from './components/Header'
import axios from "axios";

import Search from './components/Search';
import {useMainContext} from './Context/Context'

function App() {
  // const [eventData, setEventData] = useState([])
  // const [loading, setLoading] = useState(false)

  const { eventData, setEventData, reRenderMarkers} = useMainContext();
  const [loading, setLoading] = useState(false);
  //Event to render
  const [renderEvent, setRenderEvent] = useState([]);

  useEffect(() => {
    const fetchEvents = async () => {
      setLoading(true)

      axios.get('http://testcmpe-app3.us-west-1.elasticbeanstalk.com/getNASA')
            .then((response) => {
                //update the state with the response data
                console.log((response))
                setEventData(response.data.events)
                setRenderEvent(response.data.events);
                setLoading(false)

            })
            .catch(err => {
                console.log(err)
            });

    }
    fetchEvents()
  }, [])

  useEffect(() => {
    if(reRenderMarkers !== null){
      setRenderEvent(reRenderMarkers);
    }
  }, [reRenderMarkers])

  return (
    <div>
      <Header />
        { !loading ? <Map eventData={renderEvent} /> : <Loader /> }
      {!loading && <Search />}
    </div>
  );
}

export default App;