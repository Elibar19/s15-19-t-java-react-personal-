import { Alert } from 'bootstrap';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';

const initialFormData = {
    'title': '',
    'description': '',
};

function ModalDiario() {
    const [formData, setFormData] = useState(initialFormData);
    const { description, title } = formData;
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSend = () => {
        // Aquí puedes manejar la lógica para guardar la entrada en el diario
        console.log('Entrada del diario guardada:', formData);
        alert('Se agregó una nueva entrada a tu diario.')
        setFormData(initialFormData);
        handleClose();
    }

    return (
        <>
            <Button variant="primary" onClick={handleShow} className='ms-2'>
                Agregar a mi Diario
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Nueva Entrada</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form.Group controlId="exampleForm.ControlInput1" className='d-flex flex-column gap-2'>
                        <Form.Label className='mb-0'>Título</Form.Label>
                        <Form.Control
                            type="text"
                            value={title}
                            onChange={(e) => setFormData({ ...formData, title: e.target.value })}
                            placeholder="Ingrese el título de la entrada"
                            autoFocus
                        />
                        <Form.Label>Descripción</Form.Label>
                        <Form.Control
                            as="textarea"
                            rows={3}
                            value={description}
                            onChange={(e) => setFormData({ ...formData, description: e.target.value })}
                            placeholder="Ingrese la descripción de la entrada"
                            className='resize-none'
                        />
                    </Form.Group>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Cerrar
                    </Button>
                    <Button variant="primary" onClick={handleSend}>
                        Guardar
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default ModalDiario;
