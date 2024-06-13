import NewsApi from "./NewsApi"
import NavBar from "./NavBar"


const Welcome = () => {
    return (
        <div className="">
            <NavBar />
            <h2 className="text-center my-4">Ultimas Noticias</h2>
            <NewsApi />
        </div>
    )
}

export default Welcome