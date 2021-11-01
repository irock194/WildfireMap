import React from 'react';
import { Icon } from '@iconify/react'
import alertIcon from '@iconify/icons-clarity/alert-solid'

const Header = () => {
    return (
        <header className="header">
            <h1><Icon icon={alertIcon} /> Disaster Tracker </h1>
        </header>
    )
}

export default Header