import React, {
  useState,
  useEffect,
  useCallback,
  useRef,
  ChangeEvent
} from "react";
import api from "../../services/api";
import { FiLogIn, FiMail, FiLock } from "react-icons/fi";
import { Form } from "@unform/web";
import { FormHandles } from "@unform/core";
import Input from "../../components/Input";
import Button from "../../components/Button";
import { UserAuth } from "../../hooks/AuthContext";
import { Categries } from "./styled";

interface Category {
  id: string;
  nome: string;
}
interface CreateCategoryFormData {
  nome: string;
}

const FormAdd: React.FC = () => {
  const formRef = useRef<FormHandles>(null);
  const { user, token } = UserAuth();
  const [categories, setCategories] = useState<Category[]>([]);
  const handlerRemove = useCallback(async id => {
    console.log(token);

    const header = `Authorization: Bearer ${token}`;
    await api.delete(`/categories/${id}`, { headers: { header } });
  }, []);
  const handlerSubmit = useCallback(async (data: CreateCategoryFormData) => {
    const header = `Authorization: Bearer ${token}`;
    await api.post("/categories", data, { headers: { header } });
  }, []);
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
      <div>
        <div className="services-div">
          <Form ref={formRef} onSubmit={handlerSubmit}>
            <h1>Cadastrar uma nova categoria</h1>
            <Input name="nome" placeholder="" type="nome" icon={FiLogIn} />
            <Button type="submit">Cadastrar</Button>
          </Form>
        </div>
      </div>
      <Categries>
        <h1>Categorias existentes</h1>
        {categories.map(category => (
          <ul>
            <li key={category.id}>
              {category.nome}
              <button onClick={() => handlerRemove(category.id)}>
                Remover
              </button>
            </li>
          </ul>
        ))}
        <label>
          <input type="file" id="avatar" />
        </label>
      </Categries>
    </>
  );
};

export default FormAdd;
