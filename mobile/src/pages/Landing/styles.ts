import styled from "styled-components/native";
import { FlatList } from "react-native";

export const Container = styled.View`
  background: #1a1c40;
  flex: 1;
`;

export const HeaderTittle = styled.Text`
  color: #f2b591;

  font-size: 30px;
  line-height: 28px;
  text-align: center;
`;
export const ImageLogo = styled.Image`
  width: 50px;
  height: 90px;
`;
export const Image = styled.Image`
  width: 100%;
  height: 90%;
`;

export const Content = styled.View`
  align-items: center;
  justify-content: center;
  flex: 1;
`;
export const Text = styled.Text`
  font-size: 20px;
  text-align: center;
  color: #fff;
`;

export const SectionList = styled(
  FlatList as new () => FlatList<ISectionItems>
)`
  padding: 32px 24px 16px;
`;

export const Footer = styled.View`
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 20%;
`;
