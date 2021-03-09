import React, { useState, useEffect } from "react";
import api from "../../services/api";
import { Link, useHistory } from "react-router-dom";
import { UserAuth } from "../../hooks/AuthContext";
import { Header, Content } from "./styled";

interface Category {
  id: string;
  nome: string;
  imageUri: string;
}
interface CreateCategoryFormData {
  nome: string;
}
const Dashboard: React.FC = () => {
  const { user, token } = UserAuth();
  const [categories, setCategories] = useState<Category[]>([]);

  useEffect(() => {
    api.get<Category[]>("/categories").then(response => {
      const category_data = response.data.map(category => {
        return {
          ...category
        };
      });
      setCategories(category_data);
    });
  }, []);
  return (
    <>
      <Header>
        <h1>Bem vindo! {user.name}</h1>
        <button>sair</button>
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

      <div>
        {categories.map(category => (
          <ul>
            <img src={category.imageUri} alt="" />
            <li key={category.id}>{category.nome}</li>
          </ul>
        ))}
      </div>
    </>
  );
};

export default Dashboard;
