import styled from "styled-components";

export const Header = styled.header`
  display: flex;
  height: 200px;
  align-items: center;
  padding: 10px;
  background: #000080;
  margin-bottom: 15px;
  justify-content: space-between;
`;

export const Content = styled.div`
  display: flex;
  height: 150px;
  width: 100%;
  align-items: center;
  margin: 2px;
  justify-content: center;

  div {
    display: flex;
    height: 150px;
    width: 250px;
    margin: 10px;
    align-items: center;
    background: blue;
    padding: 20px;
  }
  div:hover {
    background: green;
  }
`;
