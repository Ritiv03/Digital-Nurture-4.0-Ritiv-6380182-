import React from "react";
import { mount,shallow } from "enzyme";
import CohortDetails from "./CohortDetails";
import { CohortsData } from "./Cohort";

import renderer from 'react-test-renderer';

describe("Cohort Details Component", () => {

  // Test 1: Component renders without crashing
  test("should create the component", () => {
    const wrapper = shallow(<CohortDetails cohort={CohortsData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  // Test 2: Props are passed correctly
  test("should initialize the props", () => {
    const cohort = CohortsData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    expect(wrapper.props().cohort).toEqual(cohort);
  });

  // Test 3: h3 should contain cohort code
  test("should display cohort code in h3", () => {
    const cohort = CohortsData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    const h3Text = wrapper.find('h3').text();
    expect(h3Text).toContain(cohort.cohortCode);
  });

  // Test 4: Snapshot test
  test("should always render same html", () => {
    const cohort = CohortsData[0];
    const tree = renderer.create(<CohortDetails cohort={cohort} />).toJSON();
    expect(tree).toMatchSnapshot();
  });

});