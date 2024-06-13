import axios from 'axios';

const API_URL = 'http://localhost:8080/diary';

const getAllDiaries = () => {
  return axios.get(`${API_URL}/all`);
};

const createDiary = (newDiary, userID) => {
  return axios.post(`${API_URL}/create`, newDiary, {
    params: { userID: userID }
  });
};

export default {
  getAllDiaries,
  createDiary
};