class RemoveMarqueFromVoitures < ActiveRecord::Migration[6.0]
  def change
    remove_column :voitures, :marque, :string
  end
end
