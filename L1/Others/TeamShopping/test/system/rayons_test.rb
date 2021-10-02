require "application_system_test_case"

class RayonsTest < ApplicationSystemTestCase
  setup do
    @rayon = rayons(:one)
  end

  test "visiting the index" do
    visit rayons_url
    assert_selector "h1", text: "Rayons"
  end

  test "creating a Rayon" do
    visit rayons_url
    click_on "New Rayon"

    fill_in "Label", with: @rayon.label
    click_on "Create Rayon"

    assert_text "Rayon was successfully created"
    click_on "Back"
  end

  test "updating a Rayon" do
    visit rayons_url
    click_on "Edit", match: :first

    fill_in "Label", with: @rayon.label
    click_on "Update Rayon"

    assert_text "Rayon was successfully updated"
    click_on "Back"
  end

  test "destroying a Rayon" do
    visit rayons_url
    page.accept_confirm do
      click_on "Destroy", match: :first
    end

    assert_text "Rayon was successfully destroyed"
  end
end
