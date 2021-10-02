class AddPersonneIdToVoitures < ActiveRecord::Migration[6.0]
  def change
    add_column :voitures, :personne_id, :integer
  end
end
