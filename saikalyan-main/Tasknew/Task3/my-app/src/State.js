import React,{useState,useEffect} from "react";
import SearchForm from "./Searchform";
import Display from "./Display"


function State() {
    const [searchVal, setSearchVal] = useState('Breaking Bad');
    const [mov, setMov] = useState([]);

    useEffect(() => {
        fetch(`https://api.tvmaze.com/search/shows?q=${searchVal}`)
            .then((res) => res.json())
            .then((res) => {
                console.log(res);
                setMov(data);
            })
            .catch((err) => console.log(err));
    }, [searchVal]);

    return (
        <div>
            <SearchForm setVal={setSearchVal} />
            <Display mov={mov} />
        </div>
    );
}
export default State;