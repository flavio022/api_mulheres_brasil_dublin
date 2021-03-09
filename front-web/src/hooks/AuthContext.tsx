import React, { createContext, useCallback, useState, useContext } from "react";
import api from "../services/api";
interface SiginCredentials {
  email: string;
  password: string;
}
interface AuthContextData {
  user: User;
  token: string;
  signIn(credencials: SiginCredentials): Promise<void>;
}
interface User {
  id: string;
  name: string;
  perfil_image: string;
  email: string;
}
interface AuthState {
  token: string;
  user: User;
}

const AuthContext = createContext<AuthContextData>({} as AuthContextData);

const AuthProvider: React.FC = ({ children }) => {
  var dataAtual = new Date();
  const [data, setData] = useState<AuthState>(() => {
    const token = localStorage.getItem("@Mulheres:token");
    const user = localStorage.getItem("@Mulheres:user");
    const dataStorage = localStorage.getItem("@Mulheres:dataStorage");
    if (token && user && dataAtual.toLocaleDateString() === dataStorage) {
      api.defaults.headers.authorization = `Bearer ${token}`;
      return { token, user: JSON.parse(user) };
    }
    return {} as AuthState;
  });
  const signIn = useCallback(async ({ email, password }) => {
    const response = await api.post("auth", {
      email: email,
      senha: password
    });

    const { token, user } = response.data;
    localStorage.setItem("@Mulheres:token", token);
    localStorage.setItem("@Mulheres:user", JSON.stringify(user));
    localStorage.setItem(
      "@Mulheres:dataStorage",
      dataAtual.toLocaleDateString()
    );
    api.defaults.headers.authorization = `Bearer ${token}`;
    setData({ token, user });
  }, []);

  return (
    <AuthContext.Provider
      value={{ user: data.user, token: data.token, signIn }}
    >
      {children}
    </AuthContext.Provider>
  );
};
function UserAuth(): AuthContextData {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("Use Auth must be used within an AuthProvider");
  }

  return context;
}

export { AuthContext, AuthProvider, UserAuth };
