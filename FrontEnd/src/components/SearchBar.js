const SearchBar = () => (
    <form action="/" method="get">
        <label htmlFor="header-search">
            <span className="visually-hidden">Search </span>
        </label>
        <input
            className="box"
            type="text"
            id="header-search"
            placeholder="Type to Search..."
            name="s" 
        />
        {/* <button type="submit">Search</button> */}
    </form>
);

export default SearchBar;