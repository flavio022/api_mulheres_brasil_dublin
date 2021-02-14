import React, { createContext, useCallback } from "react";
import api from "../services/api";
interface SiginCredentials {
  email: string;
  password: string;
}
interface AuthContextData {
  name: string;
  signIn(credencials: SiginCredentials): Promise<void>;
}

export const AuthContext = createContext<AuthContextData>(
  {} as AuthContextData
);
export const AuthProvider: React.FC = ({ children }) => {
  const signIn = useCallback(async ({ email, password }) => {
    const response = await api.post("auth", {
      email: email,
      senha: password
    });
    console.log(console.log(response.data));
  }, []);

  return (
    <AuthContext.Provider value={{ name: "Flavio", signIn }}>
      {children}
    </AuthContext.Provider>
  );
};
