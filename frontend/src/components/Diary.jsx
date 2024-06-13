import { useState, useEffect } from 'react';
import diaryService from '../services/diaryService';
import { Container, Row, Col, Card, Form, Button } from 'react-bootstrap';
import NavBar from './NavBar';

const Diary = () => {
  const [diaries, setDiaries] = useState([]);
  const [newDiary, setNewDiary] = useState({ titulo: '', contenido: '' });

  useEffect(() => {
    fetchDiaries();
  }, []);

  const fetchDiaries = async () => {
    const response = await diaryService.getAllDiaries();
    setDiaries(response.data);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewDiary({ ...newDiary, [name]: value });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    const userID = localStorage.getItem('userID');
    if (userID) {
      await diaryService.createDiary(newDiary, userID);
      fetchDiaries();
      setNewDiary({ titulo: '', contenido: '' });
    } else {
      alert('User not logged in');
    }
  };

  return (
    <>
    <NavBar />
    <Container>
        
      <h1 className="my-4">Diario Personal</h1>
      <Form onSubmit={handleFormSubmit}>
        <Form.Group className="mb-3">
          <Form.Label>Título</Form.Label>
          <Form.Control
            type="text"
            name="titulo"
            placeholder="Título"
            value={newDiary.titulo}
            onChange={handleInputChange}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Contenido</Form.Label>
          <Form.Control
            as="textarea"
            name="contenido"
            placeholder="Contenido"
            value={newDiary.contenido}
            onChange={handleInputChange}
            required
          />
        </Form.Group>
        <Button variant="primary" className="btn btn-success" type="submit">
          Agregar Nota
        </Button>
      </Form>
      <Row className="my-4">
        {diaries.map((diary) => (
          <Col key={diary.id} md={4} className="mb-4">
            <Card>
              <Card.Body>
                <Card.Title>{diary.titulo}</Card.Title>
                <Card.Text>{diary.contenido}</Card.Text>
                <Card.Footer>
                  <small className="text-muted">
                    {new Date(diary.fecha).toLocaleDateString()}
                  </small>
                </Card.Footer>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
    </>
  );
};

export default Diary;