class CreatePersonnes < ActiveRecord::Migration[6.0]
  def change
    create_table :personnes do |t|
      t.string :nom
      t.string :prenom
      t.date :date_naissance

      t.timestamps
    end
  end
end
