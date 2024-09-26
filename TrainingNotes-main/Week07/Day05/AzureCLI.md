### **Azure CLI Tutorial**

Azure Command-Line Interface (Azure CLI) is a powerful tool that enables you to manage Azure resources from the command line. It’s designed for managing Azure resources from any platform, including Windows, macOS, and Linux. This tutorial will guide you through the basics of using Azure CLI.

### **1. Installing Azure CLI**
Azure CLI can be installed on different operating systems. Here’s how to install it:

- **Windows:**
  - Download the installer from the [official Azure CLI installation page](https://aka.ms/installazurecliwindows) and run it.
  - Once installed, you can verify by running:
    ```bash
    az --version
    ```

- **macOS:**
  - Use Homebrew to install Azure CLI:
    ```bash
    brew update && brew install azure-cli
    ```
  - Verify the installation:
    ```bash
    az --version
    ```

- **Linux:**
  - Install using the package manager for your distribution, for example, for Ubuntu:
    ```bash
    curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash
    ```
  - Verify the installation:
    ```bash
    az --version
    ```

### **2. Authenticating to Azure**
To start using Azure CLI, you need to log in to your Azure account:

```bash
az login
```

This command will open a browser window asking you to sign in with your Azure credentials. After logging in, you’ll see a list of subscriptions you have access to.

### **3. Basic Commands**
Here are some basic commands to get you started:

- **Check Subscription:**
  ```bash
  az account show
  ```
  
- **List Available Subscriptions:**
  ```bash
  az account list
  ```

- **Set a Subscription:**
  ```bash
  az account set --subscription "Subscription_Name"
  ```

- **Create a Resource Group:**
  ```bash
  az group create --name MyResourceGroup --location eastus
  ```

- **List Resource Groups:**
  ```bash
  az group list --output table
  ```

- **Delete a Resource Group:**
  ```bash
  az group delete --name MyResourceGroup --yes --no-wait
  ```

### **4. Managing Virtual Machines (VMs)**
- **Create a Virtual Machine:**
  ```bash
  az vm create \
    --resource-group MyResourceGroup \
    --name MyVM \
    --image UbuntuLTS \
    --admin-username azureuser \
    --generate-ssh-keys
  ```

- **List Virtual Machines:**
  ```bash
  az vm list --resource-group MyResourceGroup --output table
  ```

- **Start a Virtual Machine:**
  ```bash
  az vm start --resource-group MyResourceGroup --name MyVM
  ```

- **Stop a Virtual Machine:**
  ```bash
  az vm stop --resource-group MyResourceGroup --name MyVM
  ```

- **Delete a Virtual Machine:**
  ```bash
  az vm delete --resource-group MyResourceGroup --name MyVM --yes
  ```

### **5. Managing Storage Accounts**
- **Create a Storage Account:**
  ```bash
  az storage account create \
    --name mystorageaccount \
    --resource-group MyResourceGroup \
    --location eastus \
    --sku Standard_LRS
  ```

- **List Storage Accounts:**
  ```bash
  az storage account list --output table
  ```

- **Delete a Storage Account:**
  ```bash
  az storage account delete --name mystorageaccount --resource-group MyResourceGroup --yes
  ```

### **6. Managing Databases**
- **Create an Azure SQL Database:**
  ```bash
  az sql server create \
    --name mydemoserver \
    --resource-group MyResourceGroup \
    --location eastus \
    --admin-user myadmin \
    --admin-password MyAdminPassword123

  az sql db create \
    --resource-group MyResourceGroup \
    --server mydemoserver \
    --name mySampleDatabase \
    --service-objective S0
  ```

- **List SQL Databases:**
  ```bash
  az sql db list --resource-group MyResourceGroup --server mydemoserver --output table
  ```

- **Delete an SQL Database:**
  ```bash
  az sql db delete --resource-group MyResourceGroup --server mydemoserver --name mySampleDatabase --yes
  ```

### **7. Managing Networking**
- **Create a Virtual Network:**
  ```bash
  az network vnet create \
    --resource-group MyResourceGroup \
    --name MyVnet \
    --address-prefix 10.0.0.0/16 \
    --subnet-name MySubnet \
    --subnet-prefix 10.0.0.0/24
  ```

- **List Virtual Networks:**
  ```bash
  az network vnet list --output table
  ```

### **8. Automating with Scripts**
Azure CLI supports scripting with shell scripts (Bash) or PowerShell. You can create scripts to automate repetitive tasks:

Example of a simple script to create a resource group and a VM:

```bash
#!/bin/bash

# Variables
RESOURCE_GROUP="MyResourceGroup"
LOCATION="eastus"
VM_NAME="MyVM"

# Create a resource group
az group create --name $RESOURCE_GROUP --location $LOCATION

# Create a virtual machine
az vm create \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --image UbuntuLTS \
  --admin-username azureuser \
  --generate-ssh-keys
```

### **9. Additional Resources**
- **Azure CLI Documentation:** Explore the official [Azure CLI documentation](https://docs.microsoft.com/en-us/cli/azure/).
- **Azure CLI Cheatsheet:** A handy [cheatsheet](https://aka.ms/azure-cli-cheatsheet) with common commands.

### **10. Cleanup Resources**
To avoid unnecessary charges, you should clean up resources after you're done:

```bash
az group delete --name MyResourceGroup --yes --no-wait
```

### **Conclusion**
This tutorial covers the basics of using Azure CLI for managing Azure resources. As you become more comfortable with these commands, you can explore more advanced features and integrate Azure CLI into your automation workflows.