import React from "react";
import api from "../../services/api";
import { Link, useHistory } from "react-router-dom";
import { UserAuth } from "../../hooks/AuthContext";
import { Header, Content } from "./styled";

const Dashboard: React.FC = () => {
  const { user, token } = UserAuth();

  return (
    <>
      <Header>
        <h1>Bem vindo! {user.name}</h1>
      </Header>
      <Content>
        <div>
          <Link to="/cadastrar">
            <h1>Gerenciar Categorias</h1>
          </Link>
        </div>
        <div>
          <h1>Cadastrar uma nova categoria</h1>
        </div>
        <div>
          <h1>Cadastrar uma nova categoria</h1>
        </div>
      </Content>
    </>
  );
};

export default Dashboard;
