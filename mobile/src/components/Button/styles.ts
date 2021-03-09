import styled from "styled-components/native";
import { RectButton } from "react-native-gesture-handler";
export const Container = styled(RectButton)`
  width: 90%;
  height: 60px;
  background: #d97823;
  border-radius: 10px;
  margin-top: 8px;
  justify-content: center;
  align-items: center;
`;

export const ButtonText = styled.Text`
  color: #f3f0dd;
  font-size: 25px;
`;
