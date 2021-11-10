import { Icon } from '@iconify/react'
import iceIcon from '@iconify/icons-openmoji/iceberg'

const IceMarker = ({ lat, lng, onClick }) => {
    return (
        <div className="ice-marker" onClick={onClick}>
            <Icon icon={iceIcon} className="ice-icon" />
        </div>
    )
}

export default IceMarker