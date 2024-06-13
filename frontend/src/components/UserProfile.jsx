
import { Card, ListGroup, ListGroupItem, Button} from 'react-bootstrap';
import NavBar from './NavBar';
import Logo from '../assets/img/user.jpg'// Importa tu imagen de perfil por defecto

const UserProfile = () => {
    // Datos del usuario simulados
    const user = {
        username: 'ElianBar',
        firstName: 'Elián',
        lastName: 'Bargaz',
        email: 'elian@mail.com',
        country: 'Argentina',
        role: 'Usuario estándar',
        profileImage: {Logo} // Ruta a la imagen de perfil por defecto
    };

    const handleEditProfile = () => {
        // Acción simulada para editar el perfil
        alert('Botón de edición de perfil pulsado');
    };

    return (
        <>
        <NavBar />
        <div className="container mt-5">
            <Card style={{ width: '18rem' }}>
                <Card.Img variant="top" src={Logo} alt="Imagen de perfil" />
                <Card.Body>
                    <Card.Title>Perfil de Usuario</Card.Title>
                    <ListGroup className="list-group-flush">
                        <ListGroupItem><strong>Nombre de usuario:</strong> {user.username}</ListGroupItem>
                        <ListGroupItem><strong>Nombre:</strong> {user.firstName}</ListGroupItem>
                        <ListGroupItem><strong>Apellido:</strong> {user.lastName}</ListGroupItem>
                        <ListGroupItem><strong>Email:</strong> {user.email}</ListGroupItem>
                        <ListGroupItem><strong>País:</strong> {user.country}</ListGroupItem>
                        <ListGroupItem><strong>Rol:</strong> {user.role}</ListGroupItem>
                    </ListGroup>
                    <Button variant="primary" onClick={handleEditProfile} className="mt-3 btn btn-success">
                        Editar Perfil
                    </Button>
                </Card.Body>
            </Card>
        </div>
        </>
    );
}

export default UserProfile;