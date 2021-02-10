import React from "react";
import { Form } from "@unform/web";
import { FormHandles } from "@unform/core";
import Input from "../../components/Input";
import Button from "../../components/Button";

import { FiLogIn, FiMail, FiLock } from "react-icons/fi";
import { Link, useHistory } from "react-router-dom";
import { Container, Content } from "./styled";

const handlerSubmit = () => {};
const formRef = () => {};

const SignIn: React.FC = () => {
  return (
    <Container>
      <Content>
        <Form ref={formRef} onSubmit={handlerSubmit}>
          <h1>Painel do administrador</h1>
          <Input name="email" placeholder="E-mail" icon={FiMail} />
          <Input
            name="password"
            placeholder="Senha"
            type="password"
            icon={FiLock}
          />
          <Button type="submit">Entrar</Button>
          <Link to="/forgot-password">Esqueci minha senha</Link>
        </Form>
      </Content>
    </Container>
  );
};

export default SignIn;
