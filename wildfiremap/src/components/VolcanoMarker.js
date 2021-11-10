import { Icon } from '@iconify/react'
import volcanoIcon from '@iconify/icons-maki/volcano'

const VolcanoMarker = ({ lat, lng, onClick }) => {
    return (
        <div className="volcano-marker" onClick={onClick}>
            <Icon icon={volcanoIcon} className="volcano-icon" />
        </div>
    )
}

export default VolcanoMarker