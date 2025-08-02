import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { TextEncoder, TextDecoder } from 'util';

// Polyfill for Jest (Node environment)
global.TextEncoder = TextEncoder;
global.TextDecoder = TextDecoder;

configure({ adapter: new Adapter() });
