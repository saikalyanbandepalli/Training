const Searchform = ({ setVal }) => {
    const handleSetData = (event) => {
        event.preventDefault();
        setVal(event.target.search.value);
    };

    return (
        <div>
            <form onSubmit={handleSetData}>
                <input type="text" name="search" className="form-control" placeholder="Search for a show" />
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    );
};

export default Searchform;