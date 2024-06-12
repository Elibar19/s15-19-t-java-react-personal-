import React, { useState } from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import { useNavigate } from 'react-router-dom';

function NavBar() {
    const navigate = useNavigate();
    const [searchTerm, setSearchTerm] = useState('');

    const token = localStorage.getItem('token');

    const handleCloseSession = () => {
        localStorage.clear();
        navigate('/login');
    };

    const handleSearchChange = (e) => {
        setSearchTerm(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        //aca ponemos los filtros de busqueda
        console.log('Search term:', searchTerm);
    };

    return (
        <>
            <Navbar bg="light" data-bs-theme="light" className='border'>
                <Container>
                    <div className='w-100 d-flex align-items-center justify-content-between'>
                        <Nav className="me-auto d-flex gap-2">
                            <Nav.Link onClick={() => navigate("/calendar")}>Calendario</Nav.Link>
                            <Nav.Link onClick={() => navigate("/welcome")}>Noticias</Nav.Link>
                            <Nav.Link onClick={() => navigate("/diario")}>Diario</Nav.Link>
                        </Nav>
                        <Form className="d-flex" onSubmit={handleSubmit}>
                            <FormControl
                                type="search"
                                placeholder="Buscar noticias o profesionales"
                                className="me-2"
                                aria-label="Search"
                                value={searchTerm}
                                onChange={handleSearchChange}
                            />
                            <button className="btn btn-outline-success m-1" type="submit">Buscar</button>
                        </Form>
                        {
                            token &&
                            <div>
                                <Nav.Link onClick={handleCloseSession}><button type="button" className="btn btn-danger">Cerrar sesion</button></Nav.Link>
                            </div>
                        }
                    </div>
                </Container>
            </Navbar>
        </>
    );
}

export default NavBar;