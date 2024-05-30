import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router-dom';

function NavBar() {
    const navigate = useNavigate()
    return (
        <>
            <Navbar bg="light" data-bs-theme="light" className='border'>
                <Container>
                    <Navbar.Brand href="#home" onClick={() =>navigate('/home')}>Home</Navbar.Brand>
                    <Nav className="me-auto d-flex gap-2">
                        <Nav.Link href="#features">Modulo 1</Nav.Link>
                        <Nav.Link href="#pricing">Modulo 2</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
    );
}

export default NavBar