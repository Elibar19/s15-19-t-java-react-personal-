import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import es from 'date-fns/locale/es';

const initialFormData = {
    'title': '',
    'description': '',
    'startDate': null,
    'endDate': null,
};

function ModalEvents({ onAddEvent }) {
    const [formData, setFormData] = useState(initialFormData);
    const { startDate, endDate, description, title } = formData;
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSend = () => {
        const newEvent = {
            title,
            start: startDate,
            end: endDate,
            description,
        };

        onAddEvent(newEvent);
        setFormData(initialFormData); // Restablecer el formulario a su estado inicial después de enviar

        handleClose();
    }

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Crear Evento
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Evento Nuevo</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form.Group controlId="exampleForm.ControlInput1" className='d-flex flex-column gap-2'>
                        <Form.Label className='mb-0'>Título</Form.Label>
                        <Form.Control
                            type="text"
                            value={title}
                            onChange={(e) => setFormData({ ...formData, title: e.target.value })}
                            placeholder="Ingrese el título del evento"
                            autoFocus
                        />
                        <Form.Label>Descripción</Form.Label>
                        <Form.Control
                            as="textarea"
                            rows={3}
                            value={description}
                            onChange={(e) => setFormData({ ...formData, description: e.target.value })}
                            placeholder="Ingrese la descripción del evento"
                            className='resize-none'
                        />
                        <Form.Label className='mb-0'>Fecha de Inicio</Form.Label>
                        <DatePicker
                            selected={startDate}
                            onChange={(date) => setFormData({ ...formData, startDate: date })}
                            dateFormat="dd/MM/yyyy"
                            className="form-control"
                            placeholderText="Seleccione una fecha de inicio"
                            locale={es}
                        />
                        <Form.Label className='mb-0'>Fecha de Final</Form.Label>
                        <DatePicker
                            selected={endDate}
                            onChange={(date) => setFormData({ ...formData, endDate: date })}
                            dateFormat="dd/MM/yyyy"
                            className="form-control"
                            placeholderText="Seleccione una fecha de finalización"
                            locale={es}
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

export default ModalEvents;
