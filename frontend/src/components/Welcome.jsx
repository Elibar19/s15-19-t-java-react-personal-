import NewsApi from "./NewsApi"

const Welcome = () => {
    return (
        <div className="">
            <h2 className="text-center text-primary my-4">Ultimas Noticias</h2>
            <NewsApi />
        </div>
    )
}

export default Welcome