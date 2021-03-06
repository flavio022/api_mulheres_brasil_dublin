import React, { useRef, useContext, useCallback } from "react";
import { Link, useHistory } from "react-router-dom";
import { Form } from "@unform/web";
import { FormHandles } from "@unform/core";
import Input from "../../components/Input";
import Button from "../../components/Button";
import { AuthContext } from "../../hooks/AuthContext";

import { FiMail, FiLock } from "react-icons/fi";

import { Container, Content } from "./styled";

interface SignInFormData {
  email: string;
  password: string;
}
const SignIn: React.FC = () => {
  const formRef = useRef<FormHandles>(null);
  const history = useHistory();

  const { user, signIn } = useContext(AuthContext);

  const handlerSubmit = useCallback(
    async (data: SignInFormData) => {
      try {
        signIn({ email: data.email, password: data.password });
        history.push("/dashboard");
      } catch (err) {
        return err;
      }
    },
    [signIn]
  );

  return (
    <Container>
      <Content>
        <Form ref={formRef} onSubmit={handlerSubmit}>
          <h1>Faça seu login</h1>
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
