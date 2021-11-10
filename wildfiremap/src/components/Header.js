import React from 'react';
import { Icon } from '@iconify/react'
import alertIcon from '@iconify/icons-clarity/alert-solid'
import SearchBar from './SearchBar';

const Header = () => {
    return (
        <header className="header">
            <h1><Icon icon={alertIcon} /> Disaster Tracker </h1>
            <h2><SearchBar /> </h2>
        </header>
    )
}

export default Header