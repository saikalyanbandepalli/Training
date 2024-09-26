import styled from 'styled-components';

export const Container = styled.div`
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background: #f4f4f4;
  border-radius: 8px;
`;

export const Button = styled.button`
  background: #007bff;
  color: white;
  border: none;
  padding: 10px 20px;
  margin: 5px;
  cursor: pointer;
  border-radius: 5px;

  &:hover {
    background: #0056b3;
  }
`;

export const Form = styled.form`
  display: flex;
  flex-direction: column;

  div {
    margin-bottom: 10px;
  }

  label {
    margin-bottom: 5px;
  }

  input, select {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
`;
