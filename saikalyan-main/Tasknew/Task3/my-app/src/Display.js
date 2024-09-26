const Display = ({ mov }) => {
    return (
        <>
            {mov.map((ele, idx) => (
                <h2 key={idx}>{ele.show.name}</h2>
            ))}
        </>
    );
};

export default Display;