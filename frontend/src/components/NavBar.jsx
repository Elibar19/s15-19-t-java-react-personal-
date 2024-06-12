import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router-dom';

function NavBar() {
    const navigate = useNavigate()
    const token = localStorage.getItem('token')
    const handleCloseSession = () => {
        localStorage.clear()
        navigate('/login')
    }

    return (
        <>
            <Navbar bg="light" data-bs-theme="light" className='border'>
                <Container>
                    <div className='w-100 d-flex align-items-center justify-content-between'>
                        <Navbar.Brand href="#home" onClick={() => navigate('/home')}>Home</Navbar.Brand>
                        <Nav className="me-auto d-flex gap-2">
                            <Nav.Link onClick={() => navigate("/calendar")}>Calendario</Nav.Link>
                            <Nav.Link onClick={() => navigate("/welcome")}>Noticias</Nav.Link>
                        </Nav>
                        {
                            token &&
                            <div>
                                <Nav.Link onClick={handleCloseSession}>Cerrar Sesión</Nav.Link>
                            </div>
                        }
                    </div>
                </Container>
            </Navbar>
        </>
    );
}

export default NavBar