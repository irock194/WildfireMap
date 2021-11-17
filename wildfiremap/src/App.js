import { useState, useEffect } from 'react'
import Map from './components/Map'
import Loader from './components/Loader'
import Header from './components/Header'
import axios from "axios";

function App() {
  const [eventData, setEventData] = useState([])
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    const fetchEvents = async () => {
      setLoading(true)

      axios.get('http://testcmpe-app2.us-west-1.elasticbeanstalk.com/getNASA')
            .then((response) => {
                //update the state with the response data
                console.log((response))
                setEventData(response.data.events)
                setLoading(false)

            })
            .catch(err => {
                console.log(err)
            });

    }
    fetchEvents()
  }, [])

  // useEffect(() => {
  //   const fetchEvents = async () => {
  //     setLoading(true)
  //     const res = await fetch('http://10.0.0.135:5000/getNASA',{
  //       headers : { 
  //         'Content-Type': 'application/json',
  //         'Accept': 'application/json'
  //        }}) //process.env.WILDFIRE_ENV

  //     // const res = await fetch('https://eonet.sci.gsfc.nasa.gov/api/v2.1/events')
  //     const { events } = await res.json()

  //     setEventData(events)
  //     setLoading(false)
  //   }

  //   fetchEvents()
  // }, [])

  return (
    <div>
      <Header />
      { !loading ? <Map eventData={eventData} /> : <Loader /> }
    </div>
  );
}

export default App;