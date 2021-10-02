# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# This file is the source Rails uses to define your schema when running `rails
# db:schema:load`. When creating a new database, `rails db:schema:load` tends to
# be faster and is potentially less error prone than running all of your
# migrations from scratch. Old migrations may fail to apply correctly if those
# migrations use external dependencies or application code.
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2021_05_27_075512) do

  create_table "marques", force: :cascade do |t|
    t.string "nom"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "personnes", force: :cascade do |t|
    t.string "nom"
    t.string "prenom"
    t.date "date_naissance"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "personnes_voyages", id: false, force: :cascade do |t|
    t.integer "personne_id", null: false
    t.integer "voyage_id", null: false
  end

  create_table "voitures", force: :cascade do |t|
    t.string "immatriculation"
    t.string "couleur"
    t.string "modele"
    t.date "date_mise_en_service"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.integer "marque_id"
    t.integer "personne_id"
  end

  create_table "voyages", force: :cascade do |t|
    t.string "destination"
    t.date "depart"
    t.date "retour"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

end
