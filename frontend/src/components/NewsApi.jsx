import { useEffect, useState } from "react"

const NewsApi = () => {
    // MODIFICAR URL CON UNA API QUE SI TENGA IMAGENES
    const url = 'https://newsapi.org/v2/top-headlines?country=ar&category=health&apiKey=7c79c512c5484bb7905a1f13f31bc0df'
    const [news, setNews] = useState()

    useEffect(() => {
        fetch(url)
            .then(res => {
                if (!res.ok) throw new Error("Error al realizar la peticion")
                return res.json()
            })
            .then(data => {
                console.log(data.articles)
                setNews(data.articles)
            })
            .catch(error => console.log(error.message))
    }, [])

    return (
        <div className="container px-3 d-flex justify-content-center align-items-center flex-wrap gap-5">
            {
                news?.map((item, index) => (
                    <div key={index} className="card shadow" style={{width:'18rem' }}>
                        <img src="https://via.placeholder.com/150" className="card-img-top" alt="Imagen de ejemplo" />
                        <div className="card-body">
                            <h5 className="card-title text-ellipsis" title={item.title}>{item.title}</h5>
                            <p className="card-text text-primary">{item.author}</p>
                            <a href={item.url} target="blank" className="btn btn-outline-primary">Ver Noticia</a>
                        </div>
                    </div>
                ))
            }
        </div>
    )
}

export default NewsApi