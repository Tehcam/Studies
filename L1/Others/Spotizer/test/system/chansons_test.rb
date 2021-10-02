require "application_system_test_case"

class ChansonsTest < ApplicationSystemTestCase
  setup do
    @chanson = chansons(:one)
  end

  test "visiting the index" do
    visit chansons_url
    assert_selector "h1", text: "Chansons"
  end

  test "creating a Chanson" do
    visit chansons_url
    click_on "New Chanson"

    fill_in "Date sortie", with: @chanson.date_sortie
    fill_in "Titre", with: @chanson.titre
    click_on "Create Chanson"

    assert_text "Chanson was successfully created"
    click_on "Back"
  end

  test "updating a Chanson" do
    visit chansons_url
    click_on "Edit", match: :first

    fill_in "Date sortie", with: @chanson.date_sortie
    fill_in "Titre", with: @chanson.titre
    click_on "Update Chanson"

    assert_text "Chanson was successfully updated"
    click_on "Back"
  end

  test "destroying a Chanson" do
    visit chansons_url
    page.accept_confirm do
      click_on "Destroy", match: :first
    end

    assert_text "Chanson was successfully destroyed"
  end
end
